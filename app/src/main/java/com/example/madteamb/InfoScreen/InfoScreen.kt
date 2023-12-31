package com.example.madteamb.InfoScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.madteamb.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "About Us",
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/
                                navController.navigate("Home")

                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                                 }
                },
                actions = {
                    // You can add actions (buttons, icons) here if needed
                }
            )
        }
    ) {
        var padd = it
        val teamMembers = listOf(
            TeamMember(
                name = "Hieucoolngau",
                role = "Develope App from scratch",
                bio = "Passionate about coding and solving complex problems,have a great curiosity about everything around me.",
                imageResId = R.drawable.ndh
            ),
            TeamMember(
                name = "Nguyễn Nam Dương",
                role = "Team Leader",
                bio = "",
                imageResId = R.drawable.nguyennamduong
            ),
            TeamMember(
                name = "TTPTBao",
                role = "Tester",
                bio = "Love soccer",
                imageResId = R.drawable.nngocbao
             ),


            TeamMember(
                name = "Naki",
                role = "Tester",
                bio = "",
                imageResId = R.drawable.naki
            )

            // Add more team members as needed
        )

        Column(modifier = Modifier.padding(it)) {
            teamMembers.forEach { member ->
                TeamInfo(member)
                Spacer(modifier = Modifier.height(16.dp))
            }
            Text(text = "Contact:hieu57075@gmail.com")
        }


    }
}


@Preview
@Composable
fun MyApp() {
    MaterialTheme(

    ) {
    }
}
@Composable
fun TeamInfo(teamMember: TeamMember) {
    Row(
        modifier = Modifier
            .padding(16.dp)
    ) {
        // Image of the team member on the left
        Image(
            painter = painterResource(id = teamMember.imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Information about the team member on the right
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = teamMember.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = teamMember.role,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = teamMember.bio,
                style = TextStyle(fontSize = 14.sp),
            )
        }
    }
}