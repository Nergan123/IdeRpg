package com.github.nergan123.iderpg

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

import com.github.nergan123.iderpg.rpgWindowContent.CharacterInfo
import com.github.nergan123.iderpg.rpgWindowContent.SettingsTab


internal class IdeRpg : ToolWindowFactory, DumbAware {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val characterInfoClass = CharacterInfo()
        val characterInfo = ContentFactory.getInstance().createContent(characterInfoClass.contentPanel, "Character Overview", false)
        val settingsClass = SettingsTab()
        val settings = ContentFactory.getInstance().createContent(settingsClass.contentPanel, "Settings", false)
        toolWindow.contentManager.addContent(characterInfo)
        toolWindow.contentManager.addContent(settings)
    }
}