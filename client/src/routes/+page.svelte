<script lang="ts">
    import { onMount } from "svelte";
    import "../app.css";
    import Icon from "@iconify/svelte";
    import { env } from '$env/dynamic/public';

    import FoodCard from './FoodCard.svelte';
    import type { Meal } from '$lib/types';

    // Use environment variable for API URL with fallback to localhost
    let baseUrl = env.PUBLIC_API_URL || "http://localhost:8080";

    // For more information on runes and reactivity, see: https://svelte.dev/docs/svelte/what-are-runes
    let meals: Meal[] = $state([]);

    async function fetchMeals() {
        const res = await fetch(`${baseUrl}/mensa-garching/today`);
        if (res.ok) {
            meals = await res.json();
        }
    }

    // Fetch data once on component mount
    onMount(async () => {
        // TODO Fetch meals from the API running on the baseUrl
        await fetchMeals();
    });

</script>

<main>
    <header>
        <h1>Garching Campus Canteen</h1>
        <p>Today's menu offerings</p>
    </header>

    {#if meals.length === 0}
        <div class="no-results">
            <p>Loading menu items...</p>
        </div>
    {:else}
        <div class="food-grid">
            {#each meals as meal}
                <FoodCard {meal}/>
            {/each}
        </div>
    {/if}

    {#if meals.length === 0 && meals.length > 0}
        <div class="no-results">
            No menu items match your filters. Try changing your selection.
        </div>
    {/if}
</main>
