/*
 * Copyright 2020-2023 JetBrains s.r.o. and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

package org.jetbrains.compose.demo.widgets.platform

import androidx.compose.ui.window.Window
import androidx.compose.material.Text

fun main() {
    Window("Widgets") {
        MainView()
    }
}
