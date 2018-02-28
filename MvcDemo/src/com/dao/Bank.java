package com.dao;

import java.util.ArrayList;

import com.beans.BankBean;

public interface Bank {
int login(BankBean b);
String addBank(BankBean b);
ArrayList<BankBean> viewAllBanks();
ArrayList<BankBean> searchBank(int bankId);
}
