package com.company;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Path dictionary = new Path();
        Trns translator;
        Menu menu = new Menu();
        int solution;
        do {
            menu.show();

            solution = scan.nextInt();

            switch (solution) {

                case 1:
                    System.out.println("Введите английское слово:");
                    String english = new Scanner(System.in).nextLine();
                    System.out.println("Введите перевод:");
                    String russia = new Scanner(System.in).nextLine();
                    dictionary.addWord(english, russia);
                    break;
                case 2:
                    System.out.println("Введите предложение на английском:");
                    String englishSentence = new Scanner(System.in).nextLine();
                    translator = new Trns(dictionary);
                    translator.TranslateEnglishToRussia(englishSentence);
                    break;
                case 3:
                    System.out.println("Введите перевод:");
                    String russiaSentence = new Scanner(System.in).nextLine();
                    translator = new Trns(dictionary);
                    translator.TranslateRussiaToEnglish(russiaSentence);
                    break;
                case 4:
                    System.out
                            .println("Укажите путь к файлу (например d:\\java\\dictionary.txt):");
                    String path = new Scanner(System.in).nextLine();
                    dictionary.save(path);
                    break;
                case 5:
                    System.out
                            .println("Укажите путь для сохранения файла(например d:\\java\\dictionary.txt):");
                    path = new Scanner(System.in).nextLine();
                    path.replace("\\", "\\\\");
                    dictionary.load(path);
                    break;
                case 6:
                    if (dictionary.getDictionary().size() == 0)
                        System.out
                                .println("База слов пуста! Добавьте новое слово либо загрузите базу из файла.");
                    else System.out.println(dictionary.getDictionary());
                    break;
                default:
                    if (solution != 0)
                        System.out.println("Invalid choose!");
                    break;
            }
        } while (solution != 0);
    }
}