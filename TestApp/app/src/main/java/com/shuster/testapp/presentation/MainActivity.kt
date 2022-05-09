package com.shuster.testapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.shuster.testapp.R
import com.shuster.testapp.navigation.Navigator
import com.shuster.testapp.navigation.RoteBack
import com.shuster.testapp.navigation.RoteToScreen
import com.shuster.testapp.presentation.utils.repeatWhenStarted
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var navigator: Navigator

    private val navController: NavController
        get() = findNavController(R.id.rootFragmentContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeNavigation()
    }

    private fun observeNavigation() {
        navigator.navigationFlow.repeatWhenStarted(this) { route ->
            when (route) {
                is RoteBack -> navController.navigateUp()
                is RoteToScreen -> navController.navigate(route.directions)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()
}