package Character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iceandfireapi.data.network.response.IceAndFireResponse

class CharacterViewModel: ViewModel() {
    val _character = MutableLiveData<IceAndFireResponse>()

    val character: LiveData<IceAndFireResponse> =_character





}
