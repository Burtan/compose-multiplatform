package org.jetbrains.compose.resources

abstract class ResourcesExtension {
    /**
     * Whether the generated resources accessors class should be public or not.
     *
     * Default is false.
     */
    var publicResClass: Boolean = false

    /**
     * The unique identifier of the resources in the current project.
     * Uses as package for the generated Res class and for isolation resources in a final artefact.
     *
     * If it is empty then `{group name}.{module name}.generated.resources` will be used.
     *
     */
    var resourceProjectId: String = ""

    enum class ResourceClassGeneration { Auto, Always }

    //to support groovy DSL
    val auto = ResourceClassGeneration.Auto
    val always = ResourceClassGeneration.Always

    /**
     * The mode of resource class generation.
     *
     * - `auto`: The Res class will be generated if the current project has an explicit "implementation" or "api" dependency on the resource's library.
     * - `always`: Unconditionally generate the Res class. This may be useful when the resources library is available transitively.
     */
    var generateResClass: ResourceClassGeneration = auto
}