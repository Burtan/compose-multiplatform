/*
 * Copyright 2020-2024 JetBrains s.r.o. and respective authors and developers.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE.txt file.
 */

import components.resources.demo.shared.generated.resources.Res
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals


class TestResources {

    @Test
    fun testImages() = runTest {
        val imageBytes = Res.readBytes("drawable/compose.png")

        assertEquals(31449, imageBytes.size)
    }

}
