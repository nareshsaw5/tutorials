package com.dodo.tutorials.deployment;

import java.util.List;

public class DeploymentTask extends Thread{

    private List<String> deployments;

    public void run(){
        createOrUpdate(deployments);
    }

    private void createOrUpdate(List<String> deployments){
        System.out.println("======="+Thread.currentThread().getName());
        deployments.forEach(deployment -> {
            System.out.println(deployment);
        });
        System.out.println("done");
    }
}
