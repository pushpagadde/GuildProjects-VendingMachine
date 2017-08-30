/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

/**
 *
 * @author apprentice
 */
public class MakeTags {
    // The web is built with HTML Strings like "<i>Yay</i>" which 
    // draws Yay as italic text. In this example, the "i" tag makes 
    // <i> and </i> which surround the word "Yay". Given tag and word 
    // Strings, create the HTML String with tags around the word, e.g. 
    // “<i>Yay</i>". 
    //
    // makeTags("i", "Yay") -> "<i>Yay</i>"
    // makeTags("i", "Hello") -> "<i>Hello</i>"
    // makeTags("cite", "Yay") -> "<cite>Yay</cite>"
    public String makeTags(String tag, String content) {
        if (tag != null && tag.length() > 0 && content != null && content.length() > 0 ) {
            String tagContent;
            tagContent = "<" + tag + ">" + content + "</" + tag + ">";
            System.out.println(tagContent);
            return tagContent;
        } else { 
            return null;
        }
    }
}
