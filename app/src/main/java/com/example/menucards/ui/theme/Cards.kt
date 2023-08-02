package com.example.menucards.ui.theme

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.menucards.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard() {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if(expandedState) 180f else 0f,
        label = ""
    )

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 600,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "My Title",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    modifier = Modifier
                        .weight(6f),
                    color = MaterialTheme.colorScheme.outline,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Drop-Down Arrow",
                    )
                }
            }
            if (expandedState) {
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    color = MaterialTheme.colorScheme.outline,
                    modifier = Modifier
                        .padding(12.dp)
                )
            }
        }
    }
}

@Composable
fun NormalCard(
    title: String,
    description: String,
    titleColor: Color = Color.Black,
    descriptionColor: Color = Color.Black,
    cornerShape: Dp = 9.dp
) {

    Card(
        modifier = Modifier,
        shape = RoundedCornerShape(cornerShape),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
        ) {
            Text(
                text = title,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                modifier = Modifier,
                color = titleColor
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = description,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                color = descriptionColor
            )
        }
    }
}

@Composable
fun ProductCard() {

    Card(
        modifier = Modifier
            .padding(10.dp),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardLightColor
        )
    ) {
        Column(
            modifier = Modifier
                .width(140.dp)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable._23654897456123654879),
                contentDescription = "Food",
                modifier = Modifier
                    .width(150.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Column(
                    modifier = Modifier
                        .weight(5f)
                ) {
                    Text(
                        text = "Berry Juice"
                    )
                    Text(
                        text = "$7.5",
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold
                    )
                }
                IconButton(
                    modifier = Modifier
                        .weight(1f),
                    onClick = {},
                ) {
                    Icon(
                        modifier = Modifier,
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add"
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryCard() {

    Card(
        modifier = Modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardLightColor
        )
    ) {
        Column(
            modifier = Modifier
                .width(70.dp)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.burger),
                contentDescription = "Burger",
                modifier = Modifier
                    .width(40.dp)
            )
            Text(
                text = "Burgers",
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )
        }
    }
}

@Composable
@Preview
fun ExpandableCardPreview() {
    MenuCardsTheme {
        ProductCard()
    }
}