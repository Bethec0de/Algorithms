package algorithms.interviews;


//From Software Developement Manager Interview 11/1/2016
// code scheduler.execute().
// scheduler.execute accepts a list of tasks.
// A task depends on 0 or more tasks.
// Scheduler.execute must run each task in the given list exactly once.
// A task must not be executed until all its dependencies have been executed.


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AmazonTaskScheduler{

    public class Task{

        private ArrayList<Task> tasks;

        public ArrayList<Task> getTasks(){
            return tasks;
        }

        public void setTasks(ArrayList<Task> tasks){
            this.tasks = tasks;
        }

        public void executeTask(){
            //do something
        }

    }

    public void execute(ArrayList<Task> tasks){
        Set executedTasks = new HashSet();
        //for each task
        //go through all its subtasks recursively
        //execute each subtask until there are no more
        //execute the parent task
        //return

        for(Task currentTask : tasks){
            //test that this task has not already been executed
            if(executedTasks.contains(currentTask)){
                continue;
            }

            for (int i = 0; i < currentTask.getTasks().size();i++){
                Object[] innerTasks = currentTask.getTasks().toArray();
                Task childTask = (Task)innerTasks[i];
                execute(childTask.getTasks());
            }

            currentTask.executeTask();
            executedTasks.add(currentTask) ;
        }
    }


}

// {1->3, 2->3, 3}
// {1->2, 2->1}
// {1->2, 2->3, 3->1}


