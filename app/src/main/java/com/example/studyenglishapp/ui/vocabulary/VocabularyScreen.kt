package com.example.studyenglishapp.ui.vocabulary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studyenglishapp.data.AppDatabase
import com.example.studyenglishapp.data.local.entity.WordEntity
import com.example.studyenglishapp.data.repository.WordRepository

@Composable
fun VocabularyScreen( ) {

     val context = LocalContext.current.applicationContext


    //tao db
    val database = remember {
        AppDatabase.getDatabase(context)
    }


    //tao repo
    val repository = remember {
        WordRepository(database.wordDao())
    }

    //tao factory
    val factory = remember {
        VocabularyViewModelFactory(repository)
    }

    //tao vm
    val viewModel: VocabularyViewModel = viewModel(
        factory = factory
    )

    val words by viewModel.words.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Vocabulary",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {


            items(
                items = words,
                key = { it.id }
            ) { word ->

                WordItem(word = word)

            }
        }

        // Thêm từ mẫu khi database chưa có dữ liệu
        if (words.isEmpty()) {

            Button(
                onClick = {

                    viewModel.insertWord(
                        WordEntity(
                            word = "Beautiful",
                            meaning = "Xinh đẹp",
                            pronunciation = "/ˈbjuːtɪfəl/",
                            example = "She is beautiful.",
                            exampleMeaning = "Cô ấy rất xinh đẹp.",
                            partOfSpeech = "Adjective",
                            categoryId = 1
                        )
                    )

                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Thêm từ vựng mẫu")

            }
        }
    }
}

@Composable
fun WordItem(word: WordEntity) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = word.word,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = word.meaning,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = word.pronunciation,
                style = MaterialTheme.typography.bodySmall
            )

        }
    }

}