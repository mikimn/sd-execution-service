@file:Suppress("unused", "UNUSED_PARAMETER")
package il.ac.technion.cs.softwaredesign.execution


interface ExecutionService {
    /**
     * Calls the operating system to allocate a resource with a given [id].
     * If this method succeeds, the resource is non-preemptive, i.e., the system cannot hijack it from the allocating
     * thread.
     *
     * @throws IllegalArgumentException If the system failed to allocate this resource. This means that it either
     * could not be detected (down or disconnected) or it is already allocated by a different thread.
     */
    fun allocateResource(id: String): GeneralResource

    /**
     * Signals that the calling thread releases this resource and it is subsequently returned to the operating system.
     * Subsequent calls to [allocateResource] see this resource as available in the system.
     */
    fun releaseResource(resource: GeneralResource)
}