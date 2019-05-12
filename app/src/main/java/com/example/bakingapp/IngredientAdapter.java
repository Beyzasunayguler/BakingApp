package com.example.bakingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bakingapp.models.Ingredient;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.AdapterHolder> {
    public List<Ingredient> ingredients;

    public void setIngredientsData(List<Ingredient> data) {
        this.ingredients = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View listItem = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ingredients_list_item, viewGroup, false);
        return new IngredientAdapter.AdapterHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder adapterHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return ingredients == null ? 0 : ingredients.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        public AdapterHolder(@NonNull final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent shareIntent = new Intent(itemView.getContext(), IngredientClass.class);
                    Ingredient ingredient = ingredients.get(getAdapterPosition());
                    shareIntent.putExtra(IntentConstants.INGREDIENT, ingredient.quantity);
                    shareIntent.putExtra(IntentConstants.INGREDIENT_MEASURE, ingredient.measure);
                    shareIntent.putExtra(IntentConstants.INGREDIENT_QUANTITY, ingredient.quantity);
                    itemView.getContext().startActivity(shareIntent);
                }
            });
        }
    }
}
