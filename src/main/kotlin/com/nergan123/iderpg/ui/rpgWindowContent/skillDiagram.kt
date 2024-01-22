package com.nergan123.iderpg.ui.rpgWindowContent

import com.intellij.ui.JBColor
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.geom.Path2D
import javax.swing.JPanel
import kotlin.math.cos
import kotlin.math.sin

class SkillDiagram(skillSetInput: Array<String>) : JPanel() {
    private val radius: Int = 100
    private val skills = skillSetInput.size
    private val gap = 15.0
    private val skillSet = skillSetInput

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        val g2d = g as Graphics2D
        g2d.color = JBColor.BLACK
        val star = drawDiagram(skills, g2d)
        g2d.draw(star)
    }

    private fun drawDiagram(skillNumber: Int, g2d: Graphics2D): Path2D.Double {
        val star = Path2D.Double()
        val ang = (2 * Math.PI) / skillNumber

        val firstX = 0.0 + (this.size.width / 2).toDouble()
        val firstY = 0.0 + (this.size.height / 2).toDouble() + (radius * 0.25)
        star.moveTo(firstX, firstY)

        for (i in 0 until skillNumber) {
            val x = radius * cos(i * ang - Math.PI / 2) + (this.size.width / 2)
            val y = radius * sin(i * ang - Math.PI / 2) + (this.size.height / 2) + (radius * 0.25)
            star.lineTo(x, y)
            star.moveTo(firstX, firstY)

            val xString = x + cos(i * ang - Math.PI / 2) * gap
            val yString = y + sin(i * ang - Math.PI / 2) * gap

            val metrics = g2d.fontMetrics
            val stringWidth = metrics.stringWidth(skillSet[i])
            g2d.drawString(skillSet[i], xString.toInt() - stringWidth / 2, yString.toInt())
        }

        return star
    }
}