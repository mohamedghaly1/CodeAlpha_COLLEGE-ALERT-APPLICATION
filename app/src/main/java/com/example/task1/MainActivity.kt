package com.example.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val events = listOf(
            Event("Registration Deadline", "Don't forget to register for the upcoming semester!", "The registration deadline for the Spring semester is approaching. Ensure you have selected your courses on time.", "2024-01-25"),
            Event("Class Schedule Update", "Changes to your class schedule", "Please note that there have been updates to your class schedule. Check the online portal for the revised schedule.", "2024-01-27"),
            Event("Financial Aid Disbursement", "Financial aid funds are on their way!", "Good news! Your financial aid disbursement for the current semester is scheduled to be credited to your account by the end of the week.", "2024-02-01"),
            Event("Emergency Drill", "Campus-wide emergency drill tomorrow", "We will be conducting a campus-wide emergency drill tomorrow. Familiarize yourself with the emergency procedures and participate actively.", "2024-02-05"),
            Event("Graduation Ceremony Information", "Important details about graduation", "As a graduating student, please review the latest information about the upcoming graduation ceremony. Ensure you have completed all necessary requirements.", "2024-02-10"),
            Event("Job Fair Announcement", "Explore job opportunities at the upcoming job fair", "A job fair is scheduled on campus next week. Attend to network with potential employers and explore internship and job opportunities.", "2024-02-15"),
            Event("Library Hours Update", "Changes to library hours", "Please be aware that there are changes to the library hours starting next month. Check the library website for the updated schedule.", "2024-02-20"),
            Event("Athletic Event - Basketball Game", "Cheer for our team at the basketball game", "Our college basketball team is playing a crucial game against a rival university this weekend. Show your support by attending the game!", "2024-02-25"),
            Event("Academic Advising Reminder", "Schedule your academic advising appointment", "Don't forget to schedule your academic advising appointment to discuss your course selection and academic progress for the upcoming semester.", "2024-03-01"),
            Event("Counseling Services Workshop", "Attend the mental health awareness workshop", "Join us for a workshop on mental health awareness and coping strategies. It's essential to prioritize your mental well-being during your academic journey.", "2024-03-05")
        )


        val adapter = EventAdapter(this, events)
        val eventListView: ListView = findViewById(R.id.eventListView)
        eventListView.adapter = adapter
    }
}