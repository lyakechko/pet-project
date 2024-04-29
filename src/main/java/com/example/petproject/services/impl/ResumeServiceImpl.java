package com.example.petproject.services.impl;

import com.example.petproject.dtos.DataResume;
import com.example.petproject.dtos.Experience;
import com.example.petproject.dtos.ResumeRequestDto;
import com.example.petproject.dtos.ResumeResponseDto;
import com.example.petproject.properies.DocumentProperties;
import com.example.petproject.services.ResumeService;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.draw.LineSeparator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResumeServiceImpl implements ResumeService {

    public final DocumentProperties documentProperties;

    public ResumeResponseDto getResume(ResumeRequestDto resumeRequestDto) {

        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter instance = PdfWriter.getInstance(document, out);
        document.open();
//        new RectangleReadOnly(595,842)
        Rectangle hex2474D3Rectangle = new Rectangle(0, 0, 215, 842);
        hex2474D3Rectangle.setBackgroundColor(documentProperties.getHex26703c());

//        addAvatarImage(instance.getDirectContent());

        DataResume dataResume = DataResume.getInstance(resumeRequestDto.getLanguage());

        addName(instance, dataResume);
        addHeader(instance, dataResume);
        addCommon(instance, dataResume);

        addEducation(instance, dataResume);
        addExperience(instance, dataResume);
        addVerticalLine(instance);
        addContacts(instance, dataResume);
        addContactsDetails(instance, dataResume);
        addSkills(instance, dataResume);
        addSkillDetails(instance, dataResume);
        addCommonDetails(instance, dataResume);
        addLanguage(instance, dataResume);
        addEducationDetails(instance, dataResume);
        addSLanguageDetails(instance, dataResume);
        addRectangle(instance, 652);
        addRectangle(instance, 422);
        instance.getDirectContentUnder().rectangle(hex2474D3Rectangle);
        document.close();

        log.info("success----------");
        return ResumeResponseDto.builder().resume(out.toByteArray()).build();
    }

    private void addName(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{50f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(500f);

//        Phrase phrase = new Phrase("ILYA KECHKO",
        Phrase phrase = new Phrase(dataResume.getName(),
                getFont(documentProperties.getArialStylePath(),
                        25,
                        documentProperties.getHex26703c(),
                        Font.NORMAL));
        PdfPCell fio = new PdfPCell();
        fio.setPhrase(phrase);
        fio.setBorder(PdfPCell.NO_BORDER);
        fio.setBackgroundColor(Color.WHITE);
        fio.setBorderColor(Color.WHITE);

        bankContactInfoTable.addCell(fio);

        bankContactInfoTable.writeSelectedRows(0, -1, 230, 830f, instance.getDirectContent());
    }

    private void addHeader(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{100f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(500f);

        Phrase phrase = new Phrase(dataResume.getPosition(),
                getFont(documentProperties.getMontserratStylePath(),
                        12,
                        documentProperties.getHex26703c(),
                        Font.BOLD));

        PdfPCell fio = new PdfPCell();
        fio.setPhrase(phrase);
        fio.setBorder(PdfPCell.NO_BORDER);
        fio.setBackgroundColor(Color.WHITE);
        fio.setBorderColor(Color.WHITE);

        bankContactInfoTable.addCell(fio);

        bankContactInfoTable.writeSelectedRows(0, -1, 230, 795f, instance.getDirectContent());
    }

    private void addCommon(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{50f});
        bankContactInfoTable.setWidthPercentage(90f);
        bankContactInfoTable.setTotalWidth(340f);

        Phrase phrase = new Phrase(dataResume.getCommonInfo(),
                getFont(documentProperties.getArialStylePath(),
                        10,
                        documentProperties.getHex6e7173(),
                        Font.NORMAL));

        PdfPCell fio = new PdfPCell();
        fio.setPhrase(phrase);
        fio.setBorder(PdfPCell.NO_BORDER);
        fio.setBackgroundColor(Color.WHITE);
        fio.setBorderColor(Color.WHITE);

        bankContactInfoTable.addCell(fio);

        bankContactInfoTable.writeSelectedRows(0, -1, 230, 775f, instance.getDirectContent());
    }

    private void addContacts(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{50f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(195f);

        Phrase phrase = new Phrase("  " + dataResume.getHeaderContact(),
                getFont(documentProperties.getMontserratStylePath(),
                        20,
                        Color.WHITE,
                        Font.BOLD));

        PdfPCell fio = new PdfPCell();
        fio.setPhrase(phrase);
        fio.setBackgroundColor(documentProperties.getHex26703c());
        fio.setBorderColor(documentProperties.getHex26703c());
        fio.setBorder(PdfPCell.NO_BORDER);
//        fio.setBorderColorBottom(Color.WHITE);

        PdfPCell pdfPCell = new PdfPCell(new Phrase(""));
        pdfPCell.setBackgroundColor(documentProperties.getHex26703c());
        pdfPCell.setBorderColor(documentProperties.getHex26703c());
        pdfPCell.setBorder(PdfPCell.NO_BORDER);


        PdfPCell line = new PdfPCell(new Phrase(""));
        line.setBackgroundColor(documentProperties.getHex26703c());
        line.setBorder(PdfPCell.TOP);
        line.setBorderColor(Color.WHITE);
        line.setBorderColorTop(Color.WHITE);
        bankContactInfoTable.addCell(fio);

        bankContactInfoTable.addCell(pdfPCell);
        bankContactInfoTable.addCell(line);

        bankContactInfoTable.writeSelectedRows(0, -1, 20, 670f, instance.getDirectContent());
    }

    private void addSkills(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{50f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(195f);

        Phrase phrase = new Phrase("  " + dataResume.getHeaderSkill(),
                getFont(documentProperties.getMontserratStylePath(),
                        20,
                        Color.WHITE,
                        Font.BOLD));

        PdfPCell fio = new PdfPCell();
        fio.setPhrase(phrase);
        fio.setBackgroundColor(documentProperties.getHex26703c());
        fio.setBorderColor(documentProperties.getHex26703c());
        fio.setBorder(PdfPCell.NO_BORDER);
//        fio.setBorderColorBottom(Color.WHITE);

        PdfPCell pdfPCell = new PdfPCell(new Phrase(""));
        pdfPCell.setBackgroundColor(documentProperties.getHex26703c());
        pdfPCell.setBorderColor(documentProperties.getHex26703c());
        pdfPCell.setBorder(PdfPCell.NO_BORDER);


        PdfPCell line = new PdfPCell(new Phrase(""));
        line.setBackgroundColor(documentProperties.getHex26703c());
        line.setBorder(PdfPCell.TOP);
        line.setBorderColor(Color.WHITE);
        line.setBorderColorTop(Color.WHITE);
        bankContactInfoTable.addCell(fio);

        bankContactInfoTable.addCell(pdfPCell);
        bankContactInfoTable.addCell(line);

        bankContactInfoTable.writeSelectedRows(0, -1, 20, 540f, instance.getDirectContent());
    }

    private void addLanguage(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{50f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(195f);

        Phrase phrase = new Phrase("  " + dataResume.getHeaderLanguage(),
                getFont(documentProperties.getMontserratStylePath(),
                        20,
                        Color.WHITE,
                        Font.BOLD));

        PdfPCell fio = new PdfPCell();
        fio.setPhrase(phrase);
        fio.setBackgroundColor(documentProperties.getHex26703c());
        fio.setBorderColor(documentProperties.getHex26703c());
        fio.setBorder(PdfPCell.NO_BORDER);
//        fio.setBorderColorBottom(Color.WHITE);

        PdfPCell pdfPCell = new PdfPCell(new Phrase(""));
        pdfPCell.setBackgroundColor(documentProperties.getHex26703c());
        pdfPCell.setBorderColor(documentProperties.getHex26703c());
        pdfPCell.setBorder(PdfPCell.NO_BORDER);


        PdfPCell line = new PdfPCell(new Phrase(""));
        line.setBackgroundColor(documentProperties.getHex26703c());
        line.setBorder(PdfPCell.TOP);
        line.setBorderColor(Color.WHITE);
        line.setBorderColorTop(Color.WHITE);
        bankContactInfoTable.addCell(fio);

        bankContactInfoTable.addCell(pdfPCell);
        bankContactInfoTable.addCell(line);
        bankContactInfoTable.writeSelectedRows(0, -1, 20, 120f, instance.getDirectContent());
    }


    private void addEducation(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{50f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(195f);

        Phrase phrase = new Phrase("  " + dataResume.getHeaderEducation(),
                getFont(documentProperties.getMontserratStylePath(),
                        20,
                        Color.WHITE,
                        Font.BOLD));

        PdfPCell fio = new PdfPCell();
        fio.setPhrase(phrase);
        fio.setBackgroundColor(documentProperties.getHex26703c());
        fio.setBorderColor(documentProperties.getHex26703c());
        fio.setBorder(PdfPCell.NO_BORDER);
//        fio.setBorderColorBottom(Color.WHITE);

        PdfPCell pdfPCell = new PdfPCell(new Phrase(""));
        pdfPCell.setBackgroundColor(documentProperties.getHex26703c());
        pdfPCell.setBorderColor(documentProperties.getHex26703c());
        pdfPCell.setBorder(PdfPCell.NO_BORDER);


        PdfPCell line = new PdfPCell(new Phrase(""));
        line.setBackgroundColor(documentProperties.getHex26703c());
        line.setBorder(PdfPCell.TOP);
        line.setBorderColor(Color.WHITE);
        line.setBorderColorTop(Color.WHITE);
        bankContactInfoTable.addCell(fio);

        bankContactInfoTable.addCell(pdfPCell);
        bankContactInfoTable.addCell(line);
        bankContactInfoTable.writeSelectedRows(0, -1, 20, 270f, instance.getDirectContent());
    }


    private void addAvatarImage(PdfContentByte directContent, DataResume dataResume) {
        try {
            PdfPTable imageTable = new PdfPTable(new float[]{50f});
            imageTable.setWidthPercentage(50f);
            imageTable.setTotalWidth(50f);
//            imageTable.setWidthPercentage(new float[]{10f, 10f, 10f, 10f},Reac );
            Image instance = Image.getInstance("images/ava.png");

            PdfPCell imageLogoCell = new PdfPCell(instance);
            imageLogoCell.setBorder(PdfPCell.NO_BORDER);
            imageLogoCell.setBackgroundColor(documentProperties.getHex26703c());

            imageTable.addCell(imageLogoCell);

            imageTable.writeSelectedRows(0, -1, 50f, 800f, directContent);

        } catch (Exception exception) {
            log.info("--------- {}", exception.getMessage());
            log.error("--------- {}", exception.getMessage());
        }
    }

    private static Font getFont(String stylePath, float size, Color color, int styleFont) {
        try {
            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(stylePath);

            if (Objects.nonNull(resourceAsStream)) {
                byte[] bytes = IOUtils.toByteArray(resourceAsStream);

                BaseFont baseFont = BaseFont.createFont(
                        stylePath.split("/")[1],
                        BaseFont.IDENTITY_H,
                        BaseFont.EMBEDDED,
                        true,
                        bytes,
                        null);

                return new Font(baseFont, size, styleFont, color);
            }

        } catch (Exception e) {
            log.error("Error creating font by style {} . Error : {} .", stylePath, e.getMessage());
        }

        return FontFactory.getFont(FontFactory.HELVETICA);
    }


    private void addExperience(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{50f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(340f);

        Phrase phrase = new Phrase(dataResume.getCommonExperience(),
                getFont(documentProperties.getMontserratStylePath(),
                        20,
                        documentProperties.getHex26703c(),
                        Font.BOLD));

        PdfPCell fio = new PdfPCell();
        fio.setPhrase(phrase);
        fio.setHorizontalAlignment(PdfPCell.LEFT);
        fio.setBackgroundColor(Color.WHITE);
        fio.setBorderColor(Color.WHITE);
        fio.setBorder(PdfPCell.NO_BORDER);
//        fio.setBorderColorBottom(Color.WHITE);

        PdfPCell pdfPCell = new PdfPCell(new Phrase(""));
        pdfPCell.setBackgroundColor(Color.WHITE);
        pdfPCell.setBorderColor(Color.WHITE);
        pdfPCell.setBorder(PdfPCell.NO_BORDER);


        PdfPCell line = new PdfPCell(new Phrase(""));
        line.setBackgroundColor(Color.WHITE);
        line.setBorder(PdfPCell.TOP);
        line.setBorderColor(documentProperties.getHex26703c());
        line.setBorderColorTop(documentProperties.getHex26703c());
        bankContactInfoTable.addCell(fio);

        bankContactInfoTable.addCell(pdfPCell);
        bankContactInfoTable.addCell(line);

        bankContactInfoTable.writeSelectedRows(0, -1, 230, 705f, instance.getDirectContent());
    }


    private void addContactsDetails(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{"ru".equals(dataResume.getLanguage()) ? 30f : 70f, 130f});

        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(190f);

        Phrase phrase = new Phrase(dataResume.getPhone(),
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.BOLD));

        Phrase phraseValue = new Phrase(dataResume.getPhoneValue(),
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.NORMAL));


        Phrase phrase1 = new Phrase(dataResume.getEmail(),
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.BOLD));

        Chunk chunk1 = new Chunk(dataResume.getEmailValue(), getFont(documentProperties.getMontserratStylePath(),
                10,
                Color.WHITE,
                Font.NORMAL));
        chunk1.setUnderline(0.5f, -2f);
        chunk1.setAnchor(dataResume.getEmailValue());

        Phrase phraseValue1 = new Phrase(chunk1);


        Phrase phrase2 = new Phrase(dataResume.getLinkedIn(),
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.BOLD));

        Chunk chunk = new Chunk(dataResume.getLinkedInValue(), getFont(documentProperties.getMontserratStylePath(),
                10,
                Color.WHITE,
                Font.NORMAL));
        chunk.setAnchor("https://www.linkedin.com/in/ilya-kechko-886704140/");
        chunk.setUnderline(0.5f, -2f);

        Phrase phraseValue2 = new Phrase(chunk);


        Phrase phrase3 = new Phrase(dataResume.getTelegram(),
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.BOLD));


        Chunk chunk2 = new Chunk(dataResume.getTelegramValue(), getFont(documentProperties.getMontserratStylePath(),
                10,
                Color.WHITE,
                Font.NORMAL));
        chunk2.setUnderline(0.5f, -2f);
        chunk2.setAnchor("https://t.me/KechkoIlya");
        Phrase phraseValue3 = new Phrase(chunk2);

        PdfPCell fio = new PdfPCell();
        fio.setHorizontalAlignment(PdfPCell.LEFT);
        fio.setVerticalAlignment(PdfPCell.TOP);
        fio.setBackgroundColor(documentProperties.getHex26703c());
        fio.setBorderColor(documentProperties.getHex26703c());
        fio.setBorder(PdfPCell.NO_BORDER);

        PdfPCell value = new PdfPCell();
        value.setHorizontalAlignment(PdfPCell.LEFT);
        value.setVerticalAlignment(PdfPCell.BOTTOM);
        value.setBackgroundColor(documentProperties.getHex26703c());
        value.setBorderColor(documentProperties.getHex26703c());
        value.setBorder(PdfPCell.NO_BORDER);
        value.setPhrase(phraseValue);
//        fio.setBorderColorBottom(Color.WHITE);

        fio.setPhrase(phrase);
        value.setPhrase(phraseValue);
        if ("ru".equals(dataResume.getLanguage())) {
            PdfPCell pdfPCell = new PdfPCell(new Phrase());
            pdfPCell.setBorder(PdfPCell.NO_BORDER);
            pdfPCell.setBackgroundColor(documentProperties.getHex26703c());
            bankContactInfoTable.addCell(pdfPCell);
            bankContactInfoTable.addCell(value);

            bankContactInfoTable.addCell(pdfPCell);
            value.setPhrase(phraseValue2);
            bankContactInfoTable.addCell(value);

            bankContactInfoTable.addCell(pdfPCell);
            value.setPhrase(phraseValue3);
            bankContactInfoTable.addCell(value);

            bankContactInfoTable.addCell(pdfPCell);
            value.setPhrase(phraseValue1);
            bankContactInfoTable.addCell(value);

        } else {
            bankContactInfoTable.addCell(fio);
            bankContactInfoTable.addCell(value);

            fio.setPhrase(phrase2);
            value.setPhrase(phraseValue2);
            bankContactInfoTable.addCell(fio);
            bankContactInfoTable.addCell(value);

            fio.setPhrase(phrase3);
            value.setPhrase(phraseValue3);
            bankContactInfoTable.addCell(fio);
            bankContactInfoTable.addCell(value);

            fio.setPhrase(phrase1);
            value.setPhrase(phraseValue1);
            bankContactInfoTable.addCell(fio);
            bankContactInfoTable.addCell(value);

        }

        bankContactInfoTable.writeSelectedRows(0, -1, 25, 630f, instance.getDirectContent());
    }

    private void addSkillDetails(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{100f, 100f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(175f);
        PdfPCell pdfPCell = new PdfPCell();
        pdfPCell.setBorder(PdfPCell.NO_BORDER);
        Stream.of(dataResume.getSkills()).forEach(it -> {
            Phrase phrase3 = new Phrase(it,
                    getFont(documentProperties.getMontserratStylePath(),
                            10,
                            Color.WHITE,
                            Font.NORMAL));
            pdfPCell.setPhrase(phrase3);
            bankContactInfoTable.addCell(pdfPCell);
        });
        bankContactInfoTable.writeSelectedRows(0, -1, 25, 500f, instance.getDirectContent());
    }

    private void addSLanguageDetails(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{100f, 100f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(175f);
        PdfPCell pdfPCell = new PdfPCell();
        pdfPCell.setBorder(PdfPCell.NO_BORDER);
        Stream.of(dataResume.getLanguages()).forEach(it -> {
            Phrase phrase3 = new Phrase(it,
                    getFont(documentProperties.getMontserratStylePath(),
                            10,
                            Color.WHITE,
                            Font.NORMAL));
            pdfPCell.setPhrase(phrase3);
            bankContactInfoTable.addCell(pdfPCell);
            PdfPCell pdfPCell1 = new PdfPCell();
            pdfPCell1.setBorder(PdfPCell.NO_BORDER);
            bankContactInfoTable.addCell(pdfPCell1);
        });
        bankContactInfoTable.writeSelectedRows(0, -1, 25, 80f, instance.getDirectContent());
    }
//Belarusian National Technical University

    private void addEducationDetails(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{100f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(175f);
        PdfPCell pdfPCell = new PdfPCell();
        pdfPCell.setBorder(PdfPCell.NO_BORDER);

        Chunk chunk = new Chunk("ru".equals(dataResume.getLanguage()) ? "" : dataResume.getUniversity1() + ": ",
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.NORMAL));

//
        Chunk chunk5 = new Chunk(dataResume.getUniversityValue1(),
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.NORMAL));
//        chunk5.setAnchor("https://bntu.by/en");
//        chunk5.setUnderline(0.5f, -2f);


        Chunk chunk7 = new Chunk("ru".equals(dataResume.getLanguage()) ? "" : dataResume.getDepartment() + ": ",
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.NORMAL));

        Chunk chunk1 = new Chunk(dataResume.getDepartmentValue1(),
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.NORMAL));
        chunk1.setUnderline(0.5f, -2f);
        chunk1.setAnchor(dataResume.getDepartmentLink1());
        chunk1.setUnderline(0.5f, -2f);

        Chunk chunk2 = new Chunk(dataResume.getSpecialityWithValue1(),
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.NORMAL));

        Chunk chunk3 = new Chunk(dataResume.getDepartmentValue2(),
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.NORMAL));
        chunk3.setAnchor(dataResume.getDepartmentLink2());
        chunk3.setUnderline(0.5f, -2f);


        Chunk chunk4 = new Chunk(dataResume.getSpecialityWithValue2(),
                getFont(documentProperties.getMontserratStylePath(),
                        10,
                        Color.WHITE,
                        Font.NORMAL));
//

        Phrase phrase = new Phrase();
        phrase.add(chunk);
        phrase.add(chunk5);
        pdfPCell.setPhrase(phrase);
        bankContactInfoTable.addCell(pdfPCell);


//        pdfPCell.setPhrase(new Phrase(" "));
//        bankContactInfoTable.addCell(pdfPCell);

//        Chunk chunk6 = new Chunk("\n ", getFont(documentProperties.getMontserratStylePath(),
//                10,
//                Color.WHITE,
//                Font.NORMAL));

        pdfPCell.setPhrase(new Phrase(chunk2));
        bankContactInfoTable.addCell(pdfPCell);

        Phrase phrase2 = new Phrase();
        phrase2.add(chunk7);
        phrase2.add(chunk1);
        pdfPCell.setPhrase(phrase2);
        bankContactInfoTable.addCell(pdfPCell);


        pdfPCell.setPhrase(new Phrase(" "));
        bankContactInfoTable.addCell(pdfPCell);

        pdfPCell.setPhrase(phrase);
        bankContactInfoTable.addCell(pdfPCell);

        pdfPCell.setPhrase(new Phrase(chunk4));
        bankContactInfoTable.addCell(pdfPCell);

        Phrase phrase1 = new Phrase();
        phrase1.add(chunk7);
        phrase1.add(chunk3);
        pdfPCell.setPhrase(phrase1);
        bankContactInfoTable.addCell(pdfPCell);

        bankContactInfoTable.writeSelectedRows(0, -1, 25, 240f, instance.getDirectContent());
    }

    private void addVerticalLine(PdfWriter instance) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{1f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(5f);

        PdfPCell pdfPCell = new PdfPCell();
        pdfPCell.setBorder(PdfPCell.LEFT);
        pdfPCell.setBorderColorLeft(documentProperties.getHex26703c());
        pdfPCell.setBorderColor(documentProperties.getHex26703c());
        for (int n = 0; n <= 140; n++) {
            bankContactInfoTable.addCell(pdfPCell);
        }
        bankContactInfoTable.writeSelectedRows(0, -1, 230, 652f, instance.getDirectContent());
    }

    private void addCommonDetails(PdfWriter instance, DataResume dataResume) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{100f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(330f);

        PdfPCell pdfPCell = new PdfPCell();
        pdfPCell.setBorder(PdfPCell.NO_BORDER);
        pdfPCell.setMinimumHeight(15);
        Experience.getExperiences(dataResume.getLanguage()).forEach(it -> {
            Chunk chunk = new Chunk(it.getCompany(), getFont(documentProperties.getMontserratStylePath(),
                    15,
                    documentProperties.getHex6e7173(),
                    Font.BOLD));

            Chunk chunk1 = new Chunk(it.getPeriod(), getFont(documentProperties.getArialStylePath(),
                    10,
                    documentProperties.getHex6e7173(),
                    Font.NORMAL));

            Chunk chunk2 = new Chunk(dataResume.getPositionTag() + ": ", getFont(documentProperties.getArialStylePath(),
                    10,
                    documentProperties.getHex6e7173(),
                    Font.BOLD));

            Chunk chunk3 = new Chunk(it.getPosition(), getFont(documentProperties.getArialStylePath(),
                    10,
                    documentProperties.getHex6e7173(),
                    Font.NORMAL));

            Chunk chunk4 = new Chunk(dataResume.getProjectTag() + ": ", getFont(documentProperties.getArialStylePath(),
                    10,
                    documentProperties.getHex6e7173(),
                    Font.BOLD));

            Chunk chunk5 = new Chunk(it.getProject(), getFont(documentProperties.getArialStylePath(),
                    10,
                    documentProperties.getHex6e7173(),
                    Font.NORMAL));


            Chunk chunk6 = new Chunk(it.getCommon(), getFont(documentProperties.getArialStylePath(),
                    10,
                    documentProperties.getHex6e7173(),
                    Font.NORMAL));

            Phrase phrase3 = new Phrase(chunk);
            Phrase phrase4 = new Phrase(chunk1);
            Phrase phrase5 = new Phrase();
            Phrase phrase6 = new Phrase();

            phrase5.add(chunk2);
            phrase5.add(chunk3);

            phrase6.add(chunk4);
            phrase6.add(chunk5);


            pdfPCell.setPhrase(phrase3);
            bankContactInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(phrase4);
            bankContactInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(phrase5);
            bankContactInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(phrase6);
            bankContactInfoTable.addCell(pdfPCell);
            pdfPCell.setPhrase(new Phrase(chunk6));
            bankContactInfoTable.addCell(pdfPCell);

            pdfPCell.setPhrase(new Phrase("\n"));
            bankContactInfoTable.addCell(pdfPCell);
            bankContactInfoTable.addCell(pdfPCell);
        });

        bankContactInfoTable.writeSelectedRows(0, -1, 240, 665f, instance.getDirectContent());
    }

    private void addRectangle(PdfWriter instance, float yPos) {
        PdfPTable bankContactInfoTable = new PdfPTable(new float[]{10f});
        bankContactInfoTable.setWidthPercentage(100f);
        bankContactInfoTable.setTotalWidth(5f);

        PdfPCell pdfPCell = new PdfPCell();
        pdfPCell.setBorderColor(documentProperties.getHex26703c());
        pdfPCell.setBackgroundColor(Color.WHITE);

        bankContactInfoTable.addCell(pdfPCell);

        bankContactInfoTable.writeSelectedRows(0, -1, 228, yPos, instance.getDirectContent());
    }
}
