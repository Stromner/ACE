/*
 * Copyright (C) 2020 Emerson Pinter - All Rights Reserved
 */

/*    This file is part of TQ Respec.

    TQ Respec is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    TQ Respec is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with TQ Respec.  If not, see <http://www.gnu.org/licenses/>.
*/

package tq.character.editor.copied.code.save;

@SuppressWarnings("unused")
public
class IncompatibleSavegameException extends Exception {
    public IncompatibleSavegameException() {
        super();
    }

    public IncompatibleSavegameException(String message) {
        super(message);
    }

    public IncompatibleSavegameException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncompatibleSavegameException(Throwable cause) {
        super(cause);
    }

}
