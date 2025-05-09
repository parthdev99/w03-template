<script lang="ts">
    import Icon from "@iconify/svelte";
    import type { Meal } from '$lib/types';
    let { meal }: { meal: Meal } = $props();
</script>

<div class="food-card">
    <h2>{meal.name}</h2>
    <p class="dish-type">{meal.dish_type}</p>

    <div class="label-section">
        {#if meal.labels.includes("VEGETARIAN")}
            <span class="label diet-label">
                <Icon icon="mdi:leaf" class="icon" width="16" height="16"/>Vegetarian
            </span>
        {/if}

        {#if meal.labels.includes("VEGAN")}
            <span class="label diet-label">
                <Icon icon="mdi:sprout" class="icon" width="16" height="16"/>Vegan
            </span>
        {/if}

        {#if meal.labels.includes("MEAT") || meal.labels.includes("PORK")}
            <span class="label meat-label">
                <Icon icon="mdi:food-steak" class="icon" width="16" height="16"/>Meat
            </span>
        {/if}
    </div>
</div>