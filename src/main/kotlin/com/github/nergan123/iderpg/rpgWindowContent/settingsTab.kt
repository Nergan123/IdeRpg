package com.github.nergan123.iderpg.rpgWindowContent

import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.RowLayout
import com.intellij.ui.dsl.builder.panel
import java.awt.BorderLayout
import javax.swing.BorderFactory
import javax.swing.JPanel

class SettingsTab {
    val contentPanel: JPanel = JPanel()
    private val settingsPanel: DialogPanel = createPanel()

    init {
        contentPanel.layout = BorderLayout(0, 20)
        contentPanel.border = BorderFactory.createEmptyBorder(40, 10, 0, 0)
        contentPanel.add(this.settingsPanel, BorderLayout.PAGE_START)
    }

    private fun createPanel(): DialogPanel {
        return panel {
            row("Row1 label:") {
                textField()
                label("Some text")
            }

            row("Row2:") {
                label("This text is aligned with previous row")
            }

            row("Row3:") {
                label("Rows 3 and 4 are in common parent grid")
                textField()
            }.layout(RowLayout.PARENT_GRID)

            row("Row4:") {
                textField()
                label("Rows 3 and 4 are in common parent grid")
            }.layout(RowLayout.PARENT_GRID)
        }
    }
}