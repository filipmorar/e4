package com.example.e4.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e4.model.Tag
import com.example.e4.utils.SingleLiveEvent
import com.example.e4.workers.FirstScreenWorkerInterface

class FirstViewModel(private val firstScreenWorker: FirstScreenWorkerInterface) : ViewModel() {

    val navigationCommand: SingleLiveEvent<LoginNavigationCommand> = SingleLiveEvent()

    val tagsArray = MutableLiveData<List<Tag>>()


    sealed class LoginNavigationCommand {
        object NavigateToMainScreen : LoginNavigationCommand()
    }

    init{
        firstScreenWorker.getTasks {
            val tagStringArray = ArrayList<String>()
            val tagArray = ArrayList<Tag>()
            for(task in it.tasks) {
                if(!tagStringArray.contains(task.tag)){
                    tagStringArray.add(task.tag)
                    tagArray.add(Tag(task.tag, 0.toString()))
                }
            }
            for(i in 0 until tagStringArray.size){
                var numberOfTasks = 0
                for(task in it.tasks) {
                    if(task.tag == tagStringArray[i]){
                        numberOfTasks++
                    }
                }
                tagArray[i] = Tag(tagStringArray[i], numberOfTasks.toString())
            }

            tagsArray.value = tagArray
        }
    }

    fun onClick(tag: String) {

    }

}
