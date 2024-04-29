package com.example.petproject.properies;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

@Getter
@Setter
@Component
public class DocumentProperties {
    private final String arialStylePath = "style/ArialMT.ttf";
    private final String montserratStylePath = "style/Montserrat-Light.ttf";
    private final String mapPathResource = "images/map.svg";
    private final String mailPathResource = "images/mail.svg";
    private final String logoPathResource = "images/logo.svg";
    private final String checkLogoPathResource = "images/checkLogo.svg";
    private final String stampPathResource = "images/stamp.svg";
    private final String phonePathResource = "images/phone.svg";
    private final String websitePathResource = "images/website.svg";
    private final Color hex2474D3 = Color.decode("#2474D3");
    private final Color hex26703c = Color.decode("#1750b3");
//    private final Color hex26703c = Color.decode("#26703c");
    private final Color hex6e7173 = Color.decode("#6e7173");
    private final Color hex606A7D = Color.decode("#606A7D");
    private final Color hexDFE2EB = Color.decode("#DFE2EB");

    //for sending by email
    private final String documentName = "ordering.pdf";
    private final String subjectEmail = "Выписка";
    private final String sender = "ryshkevich@yegorych.ru";

    public List<String> getHeadersCard() {
        java.util.List<String> tableHeadersCard = new ArrayList<>();
        tableHeadersCard.add("TABLE.CARD.DATE.TRANSACTION");
        tableHeadersCard.add("TABLE.CARD.INVOICE.DATE");
        tableHeadersCard.add("TABLE.CARD.NAME.OPERATION");
        tableHeadersCard.add("TABLE.CARD.STATUS.OPERATION");
        tableHeadersCard.add("TABLE.CARD.AMOUNT.ACCOUNT.CURRENCY");
        tableHeadersCard.add("TABLE.CARD.AMOUNT.TRANSACTION.CURRENCY");
        tableHeadersCard.add("TABLE.CARD.CURRENCY.OPERATION");
        tableHeadersCard.add("TABLE.CARD.ACCOUNT.BALANCE");
        tableHeadersCard.add("TABLE.CARD.PRODUCT");
        tableHeadersCard.add("TABLE.CARD.LOCATION.OPERATION");
        tableHeadersCard.add("TABLE.CARD.POINT.SERVICE");
        tableHeadersCard.add("TABLE.CARD.RRN");
        tableHeadersCard.add("TABLE.CARD.MCC.CODE");
        return tableHeadersCard;
    }

    public List<String> getHeadersAccount() {
        java.util.List<String> tableHeadersAccount = new ArrayList<>();
        tableHeadersAccount.add("TABLE.CURRENT.INVOICE.DATE");
        tableHeadersAccount.add("TABLE.CURRENT.NAME.OPERATION");
        tableHeadersAccount.add("TABLE.CURRENT.STATUS.OPERATION");
        tableHeadersAccount.add("TABLE.CURRENT.AMOUNT.ACCOUNT.CURRENCY");
        tableHeadersAccount.add("TABLE.CURRENT.AMOUNT.TRANSACTION.CURRENCY");
        tableHeadersAccount.add("TABLE.CURRENT.CURRENCY.OPERATION");
        tableHeadersAccount.add("TABLE.CURRENT.ACCOUNT.BALANCE");
        return tableHeadersAccount;
    }

    public List<String> getHeadersDeposit() {
        java.util.List<String> tableHeadersDeposit = new ArrayList<>();
        tableHeadersDeposit.add("TABLE.DEPOSIT.INVOICE.DATE");
        tableHeadersDeposit.add("TABLE.DEPOSIT.NAME.OPERATION");
        tableHeadersDeposit.add("TABLE.DEPOSIT.STATUS.OPERATION");
        tableHeadersDeposit.add("TABLE.DEPOSIT.AMOUNT.ACCOUNT.CURRENCY");
        tableHeadersDeposit.add("TABLE.DEPOSIT.AMOUNT.TRANSACTION.CURRENCY");
        tableHeadersDeposit.add("TABLE.DEPOSIT.CURRENCY.OPERATION");
        tableHeadersDeposit.add("TABLE.DEPOSIT.ACCOUNT.BALANCE");
        return tableHeadersDeposit;
    }

    public List<String> getHeadersCredit() {
        java.util.List<String> tableHeadersCredit = new ArrayList<>();
        tableHeadersCredit.add("TABLE.CREDIT.INVOICE.DATE");
        tableHeadersCredit.add("TABLE.CREDIT.NAME.OPERATION");
        tableHeadersCredit.add("TABLE.CREDIT.STATUS.OPERATION");
        tableHeadersCredit.add("TABLE.CREDIT.AMOUNT.ACCOUNT.CURRENCY");
        tableHeadersCredit.add("TABLE.CREDIT.CURRENCY.OPERATION");
        return tableHeadersCredit;
    }

    public List<String> getBankContactInfo() {
        List<String> tableHeadersCredit = new ArrayList<>();
        tableHeadersCredit.add("HEADER.LEGAL_ADDRESS");
        tableHeadersCredit.add("HEADER.GEOLOCATION");
        tableHeadersCredit.add("HEADER.CONTACT_CENTER");
        tableHeadersCredit.add("HEADER.MAIL");
        tableHeadersCredit.add("HEADER.WEBSITE");
        return tableHeadersCredit;
    }

    public List<String> getTitlesByCommonAccountActionsForPeriod() {
        List<String> titles = new ArrayList<>();
        titles.add("HEADER.STATEMENT.PERIOD.WITH");
        titles.add("HEADER.STATEMENT.INCOMING.BALANCE");
        titles.add("HEADER.STATEMENT.INCOME");
        titles.add("HEADER.STATEMENT.EXPENSES");
        titles.add("HEADER.STATEMENT.OUTGOING.BALANCE");
        titles.add("HEADER.STATEMENT.RESIDUE.PRINCIPAL.DEBT");
        titles.add("HEADER.STATEMENT.PAY");
        titles.add("HEADER.STATEMENT.AMOUNT.PAYABLE");
        return titles;
    }

    public List<String> getDepositPlanHeaders() {
        return of("TABLE.DEPOSIT.PERIOD.NUMBER", "TABLE.DEPOSIT.PERIOD",
                "TABLE.DEPOSIT.INTEREST.RATE", "TABLE.DEPOSIT.INTEREST.AMOUNT", "TABLE.DEPOSIT.INCOME.PROJECTED.TAX.WITHHOLDING.AMOUNT",
                "TABLE.DEPOSIT.INCOME.TAX.WITHHOLDING.AMOUNT", "TABLE.DEPOSIT.INTEREST.BEFORE.INCOME.TAX.TOTAL")
                .collect(toList());
    }
}
