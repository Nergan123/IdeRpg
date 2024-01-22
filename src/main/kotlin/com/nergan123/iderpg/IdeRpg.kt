package com.nergan123.iderpg

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

import com.nergan123.iderpg.ui.rpgWindowContent.CharacterInfo
import com.nergan123.iderpg.ui.rpgWindowContent.SettingsTab


internal class IdeRpg : ToolWindowFactory, DumbAware {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val characterInfo = ContentFactory.getInstance().createContent(CharacterInfo.instance.contentPanel, "Character Overview", false)
        val settings = ContentFactory.getInstance().createContent(SettingsTab.instance.contentPanel, "Settings", false)
        toolWindow.contentManager.addContent(characterInfo)
        toolWindow.contentManager.addContent(settings)
    }
}