package com.example.binhnt_lab10_screen_1;

public class TraineeRepositoy {
    public  static TraineeService getTraineeService(){
        return APIClient.getClient().create(TraineeService.class);
    }
}
