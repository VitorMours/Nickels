<script setup lang="ts">
    import { reactive } from "vue";
    function onSubmit() {

    }

</script>

<template>
        <form  class="flex flex-col p-6" novalidate @submit.prevent="onSubmit">
            <div class="card-body gap-2">
                <h2 class="card-title justify-center">Log in</h2>
                <div class="grid grid-cols-1 sm:grid-cols-2 gap-4">
                    <fieldset class="fieldset">
                        <legend class="fieldset-legend">First name</legend>
                        <input
                            type="text"
                            class="input w-full"
                            placeholder="John"
                        />
                    </fieldset>
                    <fieldset class="fieldset">
                        <legend class="fieldset-legend">Last name</legend>
                        <input
                            type="text"
                            class="input w-full"
                            placeholder="Doe"

                        />
                    </fieldset >
                </div>

                <fieldset class="fieldset">
                    <legend class="fieldset-legend">Email</legend>
                    <input
                        type="email"
                        class="input w-full"
                        placeholder="email@domain.com"
                    />
                </fieldset>
                <fieldset class="fieldset">
                    <legend class="fieldset-legend">Password</legend>
                    <input

                        type="password"
                        class="input w-full"
                        placeholder="password"
                    />
                </fieldset>
                <div class="card-actions justify-end mt-2">
                    <button type="submit" class="btn btn-primary">Log in</button>
                </div>
            </div>
        </form>
</template>
