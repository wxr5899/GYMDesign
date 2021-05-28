package com.SEGroup80.Service;

import com.SEGroup80.Pojo.BasicPojo.Order;
import com.SEGroup80.Pojo.UserPojo.Trainer;

import java.io.IOException;

public class PurchaseService {
    public void PurchaseCourseService(Trainer trainer, double price) throws IOException {
        trainer.setBalance(trainer.getBalance() - price);
        new ModifyFileService().modifyUserFile(trainer);
    }
}
