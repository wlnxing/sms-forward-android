import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wlnxing.sms_forward.Repository.DashboardRepository
import com.wlnxing.sms_forward.ui.dashboard.DashboardViewModel

class DashboardViewModelFactory(private val repository: DashboardRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DashboardViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
