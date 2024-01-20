package com.example.task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

// EventAdapter.kt
class EventAdapter(context: Context, private val events: List<Event>) : BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = events.size

    override fun getItem(position: Int): Any = events[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item_event, parent, false)
            holder = ViewHolder()
            holder.titleTextView = view.findViewById(R.id.titleTextView)
            holder.descriptionTextView = view.findViewById(R.id.descriptionTextView)
            holder.expandedDescriptionTextView = view.findViewById(R.id.expandedDescriptionTextView)
            holder.dateTextView = view.findViewById(R.id.dateTextView)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val event = getItem(position) as Event
        holder.titleTextView.text = event.title
        holder.descriptionTextView.text = event.shortDescription
        holder.expandedDescriptionTextView.text = event.longDescription
        holder.dateTextView.text = event.date

        // Set click listener to toggle visibility of expanded description
        view.setOnClickListener {
            toggleDescriptionVisibility(holder)
        }

        return view
    }

    private fun toggleDescriptionVisibility(holder: ViewHolder) {
        val expandedVisibility = if (holder.expandedDescriptionTextView.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        val collapsedVisibility = if (holder.descriptionTextView.visibility == View.VISIBLE) View.GONE else View.VISIBLE

        holder.expandedDescriptionTextView.visibility = expandedVisibility
        holder.descriptionTextView.visibility = collapsedVisibility
    }



    private class ViewHolder {
        lateinit var titleTextView: TextView
        lateinit var descriptionTextView: TextView
        lateinit var expandedDescriptionTextView: TextView
        lateinit var dateTextView: TextView
    }
}
