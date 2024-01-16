package com.github.nergan123.iderpg.state

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil


@Service
@State(name = "SettingsTabState", storages = [Storage("ideRpgStates/settingsState.xml")])
internal class SettingsTabState : PersistentStateComponent<SettingsTabState> {
    var characterName: String = "My character"

    override fun getState(): SettingsTabState {
        return this
    }

    override fun loadState(state: SettingsTabState) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        val instance: SettingsTabState
            get() = ApplicationManager.getApplication().getService(SettingsTabState::class.java)
    }
}
