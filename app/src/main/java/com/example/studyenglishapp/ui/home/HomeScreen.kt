package com.example.studyenglishapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyenglishapp.data.model.Category

@SuppressLint("RememberReturnType")
@Composable
fun HomeScreen() {

    var searchText by remember {
        mutableStateOf("")
    }

    val categories = listOf(
        Category(1, "Basic", "Basic English"),
        Category(2, "Travel", "Travel English"),
        Category(3, "Food", "Food Vocabulary"),
        Category(4, "Business", " Business English"),
        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Text(
            text = "Hello, Learner! 👋",
            fontSize = 26.sp,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = "Let's improve your English today.",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = {
                Text("Search vocabulary...")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))


        Text(
            text = "Your Progress",
            style = MaterialTheme.typography.titleLarge
        )


        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Vocabulary learned",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "65 / 100 words",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(12.dp))

                LinearProgressIndicator(
                    progress = { 0.65f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp),
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Keep going! You're doing great."
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        //daily vocabulary
        Text(
            text = "Word of the Day",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))


        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Improve",
                            fontSize = 28.sp,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Text(
                            text = "/ɪmˈpruːv/ • Verb",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    IconButton(
                        onClick = {
                         }
                    ) {
                        Icon(
                            imageVector = Icons.Default.VolumeUp,
                            contentDescription = "Pronunciation"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Cải thiện, nâng cao",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "I want to improve my English skills."
                )

                Text(
                    text = "Tôi muốn cải thiện kỹ năng tiếng Anh."
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))


        //  Categories
        Text(
            text = "Learning Categories",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(categories) { category ->

                CategoryItem(category = category)

            }
        }


        Spacer(modifier = Modifier.height(24.dp))

        //  Flashcard Banner
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(20.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = "Ready to practice?",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Learn vocabulary with Flashcards.",
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            // navigation to flash card
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                            contentColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text("Start Learning")

                        Spacer(modifier = Modifier.width(8.dp))

                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null
                        )
                    }
                }

                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(48.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}


@Composable
fun CategoryItem(category: Category) {

    Card(
        modifier = Modifier.width(150.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Icon(
                imageVector = Icons.Default.MenuBook,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = category.name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = category.description,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}