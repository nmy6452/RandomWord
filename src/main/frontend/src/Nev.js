import './Nev.css';
import React from 'react';
import ButNev from './component/ButNev';
function Nev() {
  return (
    <div className="Nev">
      <ol>
        <li>
          <ButNev name = "홈"/>
        </li>
        <li>
          <ButNev name = "랜덤 단어"/>
        </li>
        <li>
          <ButNev name = "수정"/>
        </li>
        <li>
          <ButNev name = "도움말"/>
        </li>
        <li>
          <ButNev name = "설정"/>
        </li>
      </ol>
    </div>
  );
}

export default Nev;
