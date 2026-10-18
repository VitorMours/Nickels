<script setup lang="ts">
    import { computed, ref } from "vue";

    const props = withDefaults(
        defineProps<{
            size?: 'sm' | 'md' | 'lg' | 'xl' | 'full'
            elevation?: 0 | 1 | 2 | 3
            padded?: boolean
            width?: string
            height?: string
        }>(),
        { size: 'md', elevation: 1, padded: true },
    )

    const sizes = {
        sm: 'max-w-sm',
        md: 'max-w-md',
        lg: 'max-w-2xl',
        xl: 'max-w-5xl',
        full: 'max-w-full',
    }

    const elevations = {
        0: 'border border-base-300',
        1: 'shadow-sm',
        2: 'shadow-md',
        3: 'shadow-xl',
    }

    const classes = computed(() => [
        'w-full bg-base-100 text-base-content rounded-box',
        sizes[props.size],
        elevations[props.elevation],
        props.padded ? 'p-6' : '',
    ])

    const style = computed(() => ({
        ...(props.width && { width: props.width, maxWidth: 'none' }),
        ...(props.height && { height: props.height }),
    }))

</script>

<template>
    <div :class="classes" :style="style">
        slot />
    </div>
</template>
