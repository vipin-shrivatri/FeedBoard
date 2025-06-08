package com.androidbc.feedboard.presentation.ui.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.androidbc.feedboard.domain.model.User
import com.androidbc.feedboard.presentation.ui.feature_userdetail.UserDetailScreen
import com.androidbc.feedboard.presentation.ui.feature_userlist.UserListScreen
import com.google.gson.Gson
import java.net.URLDecoder

object Routes {
    const val FEED = "feed"
    const val DETAIL_WITH_USER_JSON = "detail/{userJson}"
}

@Composable
fun AppNavGraph(startDestination: String = Routes.FEED) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = startDestination) {

        composable(Routes.FEED) {
            UserListScreen { selectedUser ->
                val encodedUser = encodeUserToRouteParam(selectedUser)
                navController.navigate("detail/$encodedUser")
            }
        }

        composable(
            route = Routes.DETAIL_WITH_USER_JSON,
            arguments = listOf(navArgument("userJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val encodedUser = backStackEntry.arguments?.getString("userJson") ?: return@composable
            val user = decodeUserFromRouteParam(encodedUser)
            UserDetailScreen(user = user, navController = navController)
        }
    }
}

fun encodeUserToRouteParam(user: User): String {
    return Uri.encode(Gson().toJson(user))
}

fun decodeUserFromRouteParam(encoded: String): User {
    return Gson().fromJson(URLDecoder.decode(encoded, "UTF-8"), User::class.java)
}
