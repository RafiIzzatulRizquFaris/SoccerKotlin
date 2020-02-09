package com.example.submission3kotlin.ui.activity

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.submission3kotlin.AppSchedulerProvider
import com.example.submission3kotlin.DataRepositoryImpl
import com.example.submission3kotlin.R
import com.example.submission3kotlin.R.drawable.ic_favorite_border_white_24dp
import com.example.submission3kotlin.R.drawable.ic_favorite_filled_white_24dp
import com.example.submission3kotlin.contract.DetailSearchContract
import com.example.submission3kotlin.database
import com.example.submission3kotlin.model.Event
import com.example.submission3kotlin.model.Favorite
import com.example.submission3kotlin.model.Team
import com.example.submission3kotlin.presenter.DetailSearchPresenter
import com.example.submission3kotlin.retrofit.RetrofitClient
import com.example.submission3kotlin.retrofit.UserService
import kotlinx.android.synthetic.main.activity_detail_event.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select


class DetailEventActivity : AppCompatActivity(), DetailSearchContract.View {

    private lateinit var mPresenter: DetailSearchPresenter
    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null
    private lateinit var idevent: String
    private lateinit var idhometeam: String
    private lateinit var idawayteam: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_event)
        val scheduler = AppSchedulerProvider()
        val retrofitClient = RetrofitClient.getClient().create(UserService::class.java)
        val request = DataRepositoryImpl(retrofitClient)
        mPresenter = DetailSearchPresenter(this, scheduler, request)
        val event: Event? = intent.getParcelableExtra("detail_event")
        idevent = event!!.idEvent!!
        idhometeam = event.idHomeTeam!!
        idawayteam = event.idAwayTeam!!
        mPresenter.getDetailSearch(event.idEvent!!)
        mPresenter.getDetailTeamHome(event.idHomeTeam!!)
        mPresenter.getDetailTeamAway(event.idAwayTeam!!)
        favoriteState(idevent)
    }

    private fun favoriteState(idevent: String) {
        database.use {
            val result = select(Favorite.TABLE_NAME)
                .whereArgs("(ID_EVENT = {idevent})", "idevent" to idevent)
            val favorite = result.parseList(classParser<Favorite>())
            if (favorite.isNotEmpty()) isFavorite = true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        menuItem = menu
        setFavorite()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.btn_favorite ->{
                if (isFavorite) removeFromFavorite() else addToFavorite()
                isFavorite = !isFavorite
                setFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addToFavorite() {
        try {
            database.use {
                insert(
                    Favorite.TABLE_NAME,
                    Favorite.ID_EVENT to idevent,
                    Favorite.STR_HOME to homeNameTv.text,
                    Favorite.STR_AWAY to awayNameTv.text,
                    Favorite.SCORE_HOME to homeScoreTv.text,
                    Favorite.SCORE_AWAY to awayScoreTv.text,
                    Favorite.IMG_HOME to idhometeam,
                    Favorite.IMG_AWAY to idawayteam,
                    Favorite.DATE_EVENT to dateScheduleTv.text
                )
            }
            Log.e("MASUK DATABASE", homeNameTv.text.toString())
            Toast.makeText(applicationContext, "Data was inserted to favorite list", Toast.LENGTH_LONG).show()
        }catch (e: SQLiteConstraintException){
            Toast.makeText(applicationContext, e.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun removeFromFavorite() {
        try {
            database.use {
                delete(Favorite.TABLE_NAME, "(ID_EVENT = {idevent})", "idevent" to idevent)
            }
            Toast.makeText(applicationContext, "Removed", Toast.LENGTH_LONG).show()
        } catch (e: SQLiteConstraintException){
            Toast.makeText(applicationContext, e.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, ic_favorite_filled_white_24dp)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, ic_favorite_border_white_24dp)
    }

    override fun setDetailSearch(listEvent: List<Event>) {
        supportActionBar?.title = listEvent[0].strEvent
        dateScheduleTv.text = listEvent[0].dateEvent
        awayNameTv.text = listEvent[0].strAwayTeam
        homeNameTv.text = listEvent[0].strHomeTeam
        homeScoreTv.text = listEvent[0].intHomeScore
        awayScoreTv.text = listEvent[0].intAwayScore
        homeScorerTv.text = listEvent[0].strHomeGoalDetails
        awayScorerTv.text = listEvent[0].strAwayGoalDetails
        gkHomeTv.text = listEvent[0].strHomeLineupGoalkeeper
        gkAwayTv.text = listEvent[0].strAwayLineupGoalkeeper
        defHomeTv.text = listEvent[0].strHomeLineupDefense
        defAwayTv.text = listEvent[0].strAwayLineupDefense
        midHomeTv.text = listEvent[0].strHomeLineupMidfield
        midAwayTv.text = listEvent[0].strAwayLineupMidfield
        forHomeTv.text = listEvent[0].strHomeLineupForward
        forAwayTv.text = listEvent[0].strAwayLineupForward
        subHomeTv.text = listEvent[0].strHomeLineupSubstitutes
        subAwayTv.text = listEvent[0].strAwayLineupSubstitutes
    }

    override fun setDetailTeamHome(listTeam: List<Team>) {
        Glide.with(this).load(listTeam[0].strTeamBadge).into(homeImg)
    }

    override fun setDetailTeamAway(listTeam: List<Team>) {
        Glide.with(this).load(listTeam[0].strTeamBadge).into(awayImg)
    }
}
