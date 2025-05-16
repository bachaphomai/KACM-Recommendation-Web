package com.Chese.KACM_Recommendation.Service;

import org.springframework.stereotype.Service;

@Service
// LoginService là một service bean.
// Spring sẽ tự động tạo một instance của LoginService và quản lý nó.
// Các lớp khác (như LoginController) có thể sử dụng LoginService thông qua dependency injection (ví dụ: thông qua @Autowired).
public class LoginService {

    public boolean authenticate(String username, String password) {
        if(username.equals("Nguyen Van Duy Anh") && password.equals("bachapphomai"))
        {
            return true;
        } else {
            return false;
        }
    }
}

// Trong đoạn code của bạn, LoginService được sử dụng trong LoginController thông qua annotation @Autowired. 
// Điều này có nghĩa là Spring Framework sẽ tự động "tiêm" (inject) một instance của LoginService vào LoginController 
// mà bạn không cần phải tạo hoặc gán thủ công.