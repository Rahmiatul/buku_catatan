package com.rahmi.buku_catatan

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rahmi.buku_catatan.databinding.ActivityAddNoteBinding


class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            if (title.isNotBlank() && content.isNotBlank()) {
                val note = Note(0, title, content)
                db.insertNonte(note)
                Toast.makeText(this, "Catatan disimpan", Toast.LENGTH_SHORT).show()
                finish() //Close AddNotActivity
            } else {
                Toast.makeText(this, "Tolong isi semua data!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}