package me.dio.soccernews.ui.favorites;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import me.dio.soccernews.ui.MainActivity;
import me.dio.soccernews.databinding.FragmentFavoritesBinding;
import me.dio.soccernews.domain.News;
import me.dio.soccernews.ui.adapters.NewsAdapter;

public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FavoritesViewModel favoritesViewModel = new ViewModelProvider(this).get(FavoritesViewModel.class);

        binding = FragmentFavoritesBinding.inflate(inflater, container, false);

        loadFavoriteNews(favoritesViewModel);

        return binding.getRoot();
    }

    private void loadFavoriteNews(FavoritesViewModel favoritesViewModel) {
        favoritesViewModel.loadFavoriteNews().observe(getViewLifecycleOwner(), localNews ->{
            binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvNews.setAdapter(new NewsAdapter(localNews, updatedNews -> {
                favoritesViewModel.saveNews(updatedNews);
                loadFavoriteNews(favoritesViewModel);
            }));
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}