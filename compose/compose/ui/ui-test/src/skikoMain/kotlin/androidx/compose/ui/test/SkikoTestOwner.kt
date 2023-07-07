/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.compose.ui.test

import androidx.compose.ui.InternalComposeUiApi
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.semantics.SemanticsNode

/**
 * Marker interface to be implemented by the Skiko `TestOwner`. The purpose is to allow code in the
 * `ui-test` module to access functions specific to the Skiko test implementation (e.g. in
 * `ui-test-junit4`).
 */
// Ideally, this would be @VisibleForTesting, but that's an Android annotation we don't want a
// dependency on
@InternalComposeUiApi
interface SkikoTestOwner {

    fun captureToImage(semanticsNode: SemanticsNode): ImageBitmap

}