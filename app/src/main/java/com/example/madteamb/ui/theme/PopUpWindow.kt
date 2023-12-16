package com.example.madteamb.ui.theme

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Dialog
import com.example.madteamb.R

@Composable
fun Dialog(
)
{


        val openDialog = remember {
            mutableStateOf(true)
        }
        if (openDialog.value)
        {
            AlertDialog(onDismissRequest = { openDialog.value = false },

                        text = {
                               Text(text = "You have work for 10 minutes this is your prize")
                        },
                        confirmButton = {
                                Button(onClick = {
                                    openDialog.value = false
                                },
                                    modifier = Modifier.padding(end = 100.dp)
                                ) {
                                    Text(text ="OK")
                                }
                        }
            )
        }

}
@Preview
@Composable
fun Previeww()
{
    Dialog()
}