package com.example.studyenglishapp.ui.vocabulary

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.example.studyenglishapp.data.local.entity.WordEntity


@SuppressLint("RememberReturnType")
@Composable
fun WordFormDialog(
    initialWord: WordEntity? = null,
    onDismiss: () -> Unit,
    onSave: (WordEntity) -> Unit
) {

    var word by remember(initialWord) {
        mutableStateOf(initialWord?.word ?: "")
    }

    var meaning by remember(initialWord) {
        mutableStateOf(initialWord?.meaning ?: "")
    }

    var pronunciation by remember(initialWord) {
        mutableStateOf(initialWord?.pronunciation ?: "")
    }

    var example by remember(initialWord) {
        mutableStateOf(initialWord?.example ?: "")
    }

    var exampleMeaning by remember(initialWord) {
        mutableStateOf(initialWord?.exampleMeaning ?: "")
    }

    var partOfSpeech by remember(initialWord) {
        mutableStateOf(initialWord?.partOfSpeech ?: "")
    }

    AlertDialog(
        onDismissRequest = onDismiss,

        title = {
            Text(
                if (initialWord == null) {
                    "Thêm từ vựng"
                } else {
                    "Chỉnh sửa từ vựng"
                }
            )
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                OutlinedTextField(
                    value = word,
                    onValueChange = { word = it },
                    label = { Text("Từ tiếng Anh") },
                    singleLine = true
                )

                OutlinedTextField(
                    value = meaning,
                    onValueChange = { meaning = it },
                    label = { Text("Nghĩa tiếng Việt") },
                    singleLine = true
                )

                OutlinedTextField(
                    value = pronunciation,
                    onValueChange = { pronunciation = it },
                    label = { Text("Phiên âm") },
                    singleLine = true
                )

                OutlinedTextField(
                    value = partOfSpeech,
                    onValueChange = { partOfSpeech = it },
                    label = { Text("Loại từ") },
                    singleLine = true
                )

                OutlinedTextField(
                    value = example,
                    onValueChange = { example = it },
                    label = { Text("Ví dụ") }
                )

                OutlinedTextField(
                    value = exampleMeaning,
                    onValueChange = { exampleMeaning = it },
                    label = { Text("Nghĩa ví dụ") }
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {

                    if (
                        word.isNotBlank() &&
                        meaning.isNotBlank()
                    ) {

                        val newWord = WordEntity(
                            id = initialWord?.id ?: 0,
                            word = word.trim(),
                            meaning = meaning.trim(),
                            pronunciation = pronunciation.trim(),
                            example = example.trim(),
                            exampleMeaning = exampleMeaning.trim(),
                            partOfSpeech = partOfSpeech.trim(),
                            categoryId = initialWord?.categoryId ?: 1,
                            isFavorite = initialWord?.isFavorite ?: false,
                            isLearned = initialWord?.isLearned ?: false
                        )

                        onSave(newWord)
                    }
                }
            ) {
                Text("Lưu")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Hủy")
            }
        }
        )
}