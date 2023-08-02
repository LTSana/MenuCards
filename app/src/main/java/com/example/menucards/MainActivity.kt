package com.example.menucards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.menucards.ui.theme.CategoryCard
import com.example.menucards.ui.theme.ExpandableCard
import com.example.menucards.ui.theme.MenuCardsTheme
import com.example.menucards.ui.theme.NormalCard
import com.example.menucards.ui.theme.ProductCard

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIPreview()
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun UIPreview() {
    MenuCardsTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text (
                    buildAnnotatedString {
                        append("Hi ")
                        withStyle(style = SpanStyle (
                            fontWeight = FontWeight.Bold
                        )) {
                            append("Sana!")
                        }
                    },
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                )
                Spacer(Modifier.height(15.dp))
                NormalCard(
                    title = "Free Combo",
                    titleColor = Color.White,
                    description = "Burger + Coca-Cola\nFor new users",
                    descriptionColor = Color.White,
                    cornerShape = 20.dp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 1..6) {
                    CategoryCard()
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
            Text(
                text = "Top Choices",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 20.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 1..5) {
                    ProductCard()
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
            Text(
                text = "Look at these yummy food!",
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(start=20.dp)
            )
            FlowRow (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
                    .padding(bottom = 20.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.Center,
                maxItemsInEachRow = 2
            ) {
                for (i in 1..7) {
                    ProductCard()
                }
            }
        }
    }
}