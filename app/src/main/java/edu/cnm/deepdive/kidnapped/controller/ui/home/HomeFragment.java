package edu.cnm.deepdive.kidnapped.controller.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.kidnapped.R;
import edu.cnm.deepdive.kidnapped.databinding.FragmentHomeBinding;

/**
 * The introductory fragment where the User selects their choice to navigate to ContactFragment or PassphraseFragment with
 * the click of each labeled button
 */

public class HomeFragment extends Fragment {

  private HomeViewModel homeViewModel;
  private FragmentHomeBinding binding;


  /**
   *
   * @param inflater inflates HomeFragment
   * @param container contains the HomeFragment layout
   * @param savedInstanceState This parameter store data needed to reload the state of the HomeFragment
   * @return returns the HomeFragment layout
   */

  @Nullable
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = edu.cnm.deepdive.kidnapped.databinding.FragmentHomeBinding.inflate(inflater);
    binding.addContactButton.setOnClickListener((v) ->
        Navigation.findNavController(getView()).navigate(HomeFragmentDirections.actionNavHomeToFragmentContact()));
    binding.passphraseButton.setOnClickListener((b) ->
        Navigation.findNavController(getView()).navigate(HomeFragmentDirections.actionNavHomeToFragmentPassphrase()));
        homeViewModel =
            new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return binding.getRoot();
  }
}