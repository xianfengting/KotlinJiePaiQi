package com.src_resources.metronome

import javax.swing.UIManager

fun main(args: Array<String>) {
    run {
        val className = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(className)
    }

    val amf = AppMainFrame()
    amf.isVisible = true
}
