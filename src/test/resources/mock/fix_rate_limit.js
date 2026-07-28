window.__yoyTestSecret = '000000';

  const originalFetch = window.fetch;
  window.fetch = function(input, init = {}) {
    const url = typeof input === 'string' ? input : input.url;

    if (url.includes('/auth/email-otp/request')) {
      init.headers = {
        ...(init.headers || {}),
        'x-yoy-test-secret': window.__yoyTestSecret
      };
    }

    return originalFetch(input, init);
  };