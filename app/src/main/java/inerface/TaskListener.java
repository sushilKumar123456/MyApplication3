package inerface;

/**
 * Created by Sushil on 1/31/2017.
 */

public interface  TaskListener {
    void onTaskStarted();

    void onTaskFinished(String result);
}
