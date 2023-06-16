import React, { useState, useEffect } from 'react';

const SearchBar = ({ onSearch }) => {
  const [searchText, setSearchText] = useState('');

  const handleInputChange = (event) => {
    setSearchText(event.target.value);
  };

  useEffect(() => {
    onSearch(searchText);
  }, [searchText]);

  return (
    <input
      className="rounded bg-slate-600 text-white px-2 py-2 w-15 mx-0 my-2 ont-semibold"
      type="text"
      placeholder="İsim veya soyisim girin"
      value={searchText}
      onChange={handleInputChange}

    />
  );
};

export default SearchBar;