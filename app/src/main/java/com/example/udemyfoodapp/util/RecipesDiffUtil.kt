package com.example.udemyfoodapp.util

import androidx.recyclerview.widget.DiffUtil
import com.example.udemyfoodapp.models.Result

class RecipesDiffUtil(
    private val oldList: List<Result>,
    private val newList: List<Result>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int{
        return oldList.size
    } // returns the size of the old list

    override fun getNewListSize(): Int{
        return newList.size
    } // returns the size of the new list

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition:Int): Boolean{
        return oldList[oldItemPosition] === newList[newItemPosition]
    } //Called by the DiffUtil to decide whether 2 objects represent the same item in the old and new list

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean{
        return oldList[oldItemPosition] == newList[newItemPosition]
    } //checks if 2 items have the same data



}