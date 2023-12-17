package com.example.madteamb.StoreScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.madteamb.R
import com.example.madteamb.ui.theme.Coin.Coin
import com.example.madteamb.ui.theme.GreenBackGround

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreScreen(navController: NavController) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(GreenBackGround)
                ,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                IconButton(onClick = { /*TODO*/
                        navController.navigate("Home")
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
                Text(
                    text = "VJU Store",
                    color = Color.Black
                )
                Row(  modifier = Modifier
                    .padding(10.dp)
                    .size(70.dp, 20.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .fillMaxWidth()) {

                    Text(
                        text =  60.toString(),
                        color = GreenBackGround,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Image(painter = painterResource(id = R.drawable.iconscoin), contentDescription = null )
                }

            }
        },

        content = {
            Box(modifier = Modifier.padding(it))
            {
                StoreContent()
            }
        }
    )
}

@Composable
fun StoreContent() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(productList.chunked(2)) { rowProducts ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 26.dp)
            ) {
                rowProducts.forEach { product ->
                    ProductItem(product = product, modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.width(20.dp))
                }
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .border(2.dp, MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.small)
            .fillMaxWidth()
        ,

        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = product.imageResId),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = product.name,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 4.dp, start = 39.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${product.price} ",
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.padding(start =40.dp)
            )

            Image(
                painter = painterResource(R.drawable.iconscoin),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                // clip to the circle shape
            )
//
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}


val productList = listOf(
    Product(1, "Salad", "30", R.drawable.salad, 4.5f),
    Product(2, "Burger", "40", R.drawable.burger, 3.5f),
    Product(3, "Bibimbap", "30", R.drawable.bibimbap, 5f),
    Product(4, "Ramen", "40", R.drawable.ramen, 5f),
    Product(5, "Kare Raisu", "60", R.drawable.kareraisu4381829, 5f),
    Product(6, "Fried Chicken", "70", R.drawable.friedchicken, 5f),


    // Add more products as needed
)

@Preview
@Composable
fun StoreScreenPreview() {
}
