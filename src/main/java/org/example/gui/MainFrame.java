package org.example.gui;

import org.example.EngTextMethods;
import org.example.TgwTehtarTextMethods;
import org.example.TgwTextMethods;
import org.example.TengwarMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame {
    private TengwarMode tengwarMode;
    JFrame frame;
    JButton goButton;
    JTextArea inputArea;
    JLabel outputLabel, outputLabel2;
    JComboBox<String> modePicker;

    private final int PADDING = 20;
    private final int AREA_WIDTH = 270;
    private final int AREA_HEIGHT = 200;
    private final int OUTPUT_HEIGHT = 360;
    private final int BUTTON_WIDTH = 220;
    private final int BUTTON_HEIGHT = 60;
    private final int PICKER_HEIGHT = 30;
    private static final String PICKER_MODE_AUTHOR_FULL = "Full mode by author";
    private static final String PICKER_MODE_AUTHOR_OMATEHTA = "Ómatehta by author";


    //    private final int padding = 20;
    public MainFrame() {
        tengwarMode = TengwarMode.FULLMODE_AUTHOR;
        frame = new JFrame("Tengwar transliterator");
        frame.setSize(600, 600);
        frame.setLayout(null);

        Font tengwarFont = generateTengwarFont();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(tengwarFont);

        inputArea = new JTextArea();
        inputArea.setBounds(PADDING, PADDING, AREA_WIDTH, AREA_HEIGHT);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        frame.add(inputArea);

        final String html = "<html><body style='width: %1spx'>%1s";
        outputLabel = new JLabel("output1", SwingConstants.CENTER);
        outputLabel.setBounds(PADDING + AREA_WIDTH + PADDING, PADDING, AREA_WIDTH, OUTPUT_HEIGHT);
        outputLabel.setVerticalAlignment(SwingConstants.TOP);
        frame.add(outputLabel);
        outputLabel.setFont(tengwarFont);

        outputLabel2 = new JLabel("output2", SwingConstants.CENTER);
        outputLabel2.setBounds(PADDING + AREA_WIDTH + PADDING, PADDING + OUTPUT_HEIGHT + PADDING, AREA_WIDTH, OUTPUT_HEIGHT);
        outputLabel2.setVerticalAlignment(SwingConstants.TOP);
        frame.add(outputLabel2);

        String[] inputModes = {PICKER_MODE_AUTHOR_OMATEHTA, PICKER_MODE_AUTHOR_FULL};
        modePicker = new JComboBox<>(inputModes);
        modePicker.setBounds(PADDING, PADDING + OUTPUT_HEIGHT + PADDING, BUTTON_WIDTH, PICKER_HEIGHT);
        frame.add(modePicker);

        goButton = new JButton("Transliterate"); //TODO activate with Enter key
        goButton.setBounds(PADDING, PADDING + OUTPUT_HEIGHT + PADDING + PICKER_HEIGHT + PADDING, BUTTON_WIDTH, BUTTON_HEIGHT);
        frame.add(goButton);
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get mode
                String input = inputArea.getText().toLowerCase();
                String pickedMode = modePicker.getItemAt(modePicker.getSelectedIndex());
                String transliteratedOutput = performTranslitSequence(input, pickedMode);
                String formattedOutput = String.format(html, 200, transliteratedOutput);
                outputLabel.setText(formattedOutput);
                outputLabel2.setText(formattedOutput);
                /*if (modePicker.getItemAt(modePicker.getSelectedIndex()).equals(PICKER_MODE_AUTHOR_OMATEHTA)) {
//                    tengwarMode = TengwarMode.OMATEHTA_AUTHOR;
                } else if (modePicker.getItemAt(modePicker.getSelectedIndex()).equals(PICKER_MODE_AUTHOR_FULL)) {
//                    tengwarMode = TengwarMode.FULLMODE_AUTHOR;
                    String formattedOutput = String.format(html, 200, performTranslitSequence(input));
                    outputLabel.setText(formattedOutput);
                    outputLabel2.setText(formattedOutput);
                }*/
            }
        });

        frame.setVisible(true);
    }

    private String performTranslitSequence(String input, String pickedMode) {
        String output = EngTextMethods.translWordDigraphsSimple(input);
        output = EngTextMethods.translWordCharsSimple(output);
        output = TgwTextMethods.fixOfThes(output);
        if (pickedMode.equals(PICKER_MODE_AUTHOR_FULL)) {
            
            output = TgwTextMethods.putDotsForFullMode(output);
        } else if (pickedMode.equals(PICKER_MODE_AUTHOR_OMATEHTA)) {
            output = TgwTextMethods.fixNasals(output);
            output = TgwTextMethods.fixDoubleConsonants(output);
            output = TgwTehtarTextMethods.tehtarizeVowels(output);
            output = TgwTehtarTextMethods.fixDiphtongs(output);
        }
//        output = TgwTextMethods.
//        output = TgwTextMethods.fixFinalNGs(output); //TODO
        return output;
    }
    private Font generateTengwarFont() {
        String path = "src\\main\\fonts\\tngan.ttf";
        File tengwarFontFile = new File(path);
        Font tengwarFontSmall;
        try {
            tengwarFontSmall = Font.createFont(Font.TRUETYPE_FONT, tengwarFontFile);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Font tengwarFont = tengwarFontSmall.deriveFont(20.0F);
        return tengwarFont;
    }
}